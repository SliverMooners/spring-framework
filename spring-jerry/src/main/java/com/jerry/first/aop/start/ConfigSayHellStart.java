package com.jerry.first.aop.start;

import com.jerry.first.aop.NeedAopCglibService;
import com.jerry.first.aop.NeedAopService;
import com.jerry.first.aop.NoNeedAopService;
import com.jerry.first.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigSayHellStart {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotation = new AnnotationConfigApplicationContext(SpringConfig.class);
		final NeedAopService needAopService = annotation.getBean(NeedAopService.class);



		//      以下代码由$Proxy0.class反编译得到
		//		public final class $Proxy0 extends Proxy implements PorxyInte {
		//			private static Method m3;
		//
		//			static {
		//				m3 = Class.forName("cn.itcast.web.Test.PorxyInte").getMethod("test", new Class[0]);
		//			}
		//
		//			//构造方法。将invocationhandler实例从代理类赋值到父类
		//			public $Proxy0(InvocationHandler invocationhandler) {
		//				super(invocationhandler);//创建父类对象
		//			}

		//			//此处可以看出，当调用代理类的test方法，会执行父类对象属性h的invoke方法，
		//			//h即为通过匿名内部类创建的处理器对象
		//			public final void test() {
		//				super.h.invoke(this, m3, null);    //这里的this是代理对象，m3为test方法
		//			}
		//		}


		System.out.println(needAopService);
		System.out.println(needAopService.getClass());
		needAopService.aopAdd();
		System.out.println("--------------------------------------");
		final NoNeedAopService noNeedAopService = annotation.getBean(NoNeedAopService.class);
		System.out.println(noNeedAopService);
		System.out.println(noNeedAopService.getClass());
		noNeedAopService.noAopAdd();
		final NeedAopCglibService needAopCglibService = annotation.getBean(NeedAopCglibService.class);
		System.out.println(needAopCglibService);
		System.out.println(needAopCglibService.getClass());
		needAopCglibService.needProxy();
	}

}
