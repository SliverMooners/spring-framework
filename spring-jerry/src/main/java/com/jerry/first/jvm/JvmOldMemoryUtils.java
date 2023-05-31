//package com.jerry.first.jvm;
//
//import cn.hutool.core.collection.ConcurrentHashSet;
//import com.alibaba.fastjson.JSON;
//import com.yiche.rcd.common.pojo.WeChatWarningEntity;
//import com.yiche.rcd.recall.config.NacosGlobalConfig;
//import com.yiche.rcd.recall.service.impl.LoadDictService;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.collections4.CollectionUtils;
//import org.apache.lucene.util.RamUsageEstimator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.lang.management.ManagementFactory;
//import java.lang.management.MemoryPoolMXBean;
//import java.lang.management.MemoryUsage;
//import java.lang.reflect.Field;
//import java.net.InetAddress;
//import java.net.URLEncoder;
//import java.util.*;
//
///**
// * @author fanc
// */
//@Slf4j
//@Component
//public class JvmOldMemoryUtils {
//
//    @Autowired
//    NacosGlobalConfig nacosGlobalConfig;
//
//    @Autowired
//    LoadDictService loadDictService;
//
//    Set<String> notLoadDict = new ConcurrentHashSet<>(200);
//
//    private static final long M = 1024 * 1204;
//
//    private volatile long oldMemoryMaxSize = 0;
//
//    private volatile long useMemorySize = 0;
//
//    public boolean checkJvmIsLimit(String fileName) {
//        boolean loadFlag = true;
//        try {
//            List<MemoryPoolMXBean> mxb = ManagementFactory.getMemoryPoolMXBeans();
//            for (MemoryPoolMXBean memoryPool : mxb) {
//                if (memoryPool.getName().contains("Old Gen")) {
//                    final MemoryUsage oldMemory = memoryPool.getUsage();
//                    final long oldSize = (oldMemory.getMax() <= 0? oldMemory.getCommitted():oldMemory.getMax()) / M;
//                    final long usedSize = oldMemory.getUsed() / M;
//                    long oldMemoryPercent = usedSize * 100 / oldSize;
//                    log.info("fanc test oldSize: {}M, usedSize: {}M, fileName: {}", oldSize, usedSize , fileName);
//                    if (oldMemoryPercent > nacosGlobalConfig.getOldMemoryLimit()) {
//                        notLoadDict.add(fileName);
//                        oldMemoryMaxSize = oldSize;
//                        useMemorySize = usedSize;
//                        loadFlag = false;
//                    }
//                    break;
//                }
//            }
//
//        } catch (Exception e) {
//            log.error("JVMOldMemoryUtils checkJvmIsLimit---> error:", e);
//        }
//        return loadFlag;
//    }
//
//    public void handleDictMemory() {
//        try {
//            if (CollectionUtils.isNotEmpty(notLoadDict)) {
//                Map<String, String> bigObjMap = new HashMap<>();
//                final Field[] declaredFields = loadDictService.getClass().getDeclaredFields();
//                long totalObjectMemory = 0;
//                for (Field field : declaredFields) {
//                    field.setAccessible(true);
//                    final Object obj = field.get(loadDictService);
//                    if (obj != null) {
//                        final long objSize = RamUsageEstimator.sizeOfObject(obj) / M;
//                        totalObjectMemory += objSize;
//                        if (objSize > 50) {
//                            bigObjMap.put(field.getName(), objSize + "M");
//                        }
//                    }
//                }
//
//                log.info("fanc test 未加载的文件:{}, 大文件集合bigObjMap:{}, 字典对象共占用内存:{}", notLoadDict, bigObjMap, totalObjectMemory);
//                // sendWarningsToRobot(notLoadDict,bigObjMap);
//                sendWarningsToRobotWithGet(notLoadDict);
//            }
//        } catch (Exception e) {
//            log.error("JVMOldMemoryUtils sendWarningsToRobot ---> error:", e);
//        } finally {
//            notLoadDict = new ConcurrentHashSet<>(200);
//            oldMemoryMaxSize = 0;
//            useMemorySize = 0;
//        }
//    }
//
//    private void sendWarningsToRobot(Set<String> notLoadDict,Map<String, String> bigObjMap) {
//        try {
//            final InetAddress ip = InetAddress.getLocalHost();
//            WeChatWarningEntity wechat = new WeChatWarningEntity();
//            wechat.setKey("0ceeabad-093b-4f44-a62b-c8730b144cf3");
//            List<String> members = new ArrayList<>();
//            members.add("18570");
//            wechat.setMentionedMobileList(members);
//
//            String msg = "jvm老年代超过阈值: "+nacosGlobalConfig.getOldMemoryLimit()+"%\nip: "+ip+"\n限制加载的文件: "+notLoadDict+"\n内存中字典大对象: "+JSON.toJSONString(bigObjMap)
//                    +"\n老年代共计: "+oldMemoryMaxSize+"M, 已使用: "+useMemorySize+"M, percent:"+useMemorySize*100/oldMemoryMaxSize;
//
//            wechat.setContent(msg);
//            HttpUtil.post("http://rcd-alarm.in.bitautotech.com/rc/wx/sendEwxAlarm", JSON.toJSONString(wechat));
//        }catch (Exception e) {
//            log.error("JVMOldMemoryUtils sendWarningsToRobot ---> error:", e);
//        }
//    }
//
//    private void sendWarningsToRobotWithGet(Set<String> notLoadDict) {
//        try {
//            final InetAddress ip = InetAddress.getLocalHost();
//            String msg = URLEncoder.encode("ip:"+ip+",configLimit:"+nacosGlobalConfig.getOldMemoryLimit()+"%,notLoad:"+notLoadDict+",oldSize:"+oldMemoryMaxSize+"M,userSize:"+useMemorySize+"M,percent:"+useMemorySize*100/oldMemoryMaxSize, "UTF-8");
//            String url = "http://rc.item2.inneryiche.com/dictAlarm/alarm/someone?mailList=fanc@yiche.com&content="+msg;
//            HttpUtil.get(url);
//        }catch (Exception e) {
//            log.error("JVMOldMemoryUtils sendWarningsToRobot ---> error:", e);
//        }
//    }
//
//
//}
