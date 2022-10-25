package com.nttdata.sesion4.schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SingleScheduler {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("invoke singleScheduler main --->");
		
		System.out.println("number of processors available to the Java virtual machine: " + Runtime.getRuntime().availableProcessors());
		
		method1();
		//method2();
		Thread.sleep(100000);
		
	}
	
	private static void method1() throws InterruptedException {
		
		System.out.println("Invoke method1");
		
		Observable<Object> source = Observable.create(
				e ->{
					e.onNext("Hello");
					Thread.sleep(2000);
					e.onNext("RxJava");
					Thread.sleep(2000);
					e.onComplete();
				})
				.subscribeOn(Schedulers.single());
		
		source.subscribe(e -> System.out.println("Observer1 : "+ e + " : Thread: "+ Thread.currentThread().getName()));
		source.subscribe(e -> System.out.println("Observer2 : "+ e + " : Thread: "+ Thread.currentThread().getName()));
		source.subscribe(e -> System.out.println("Observer3 : "+ e + " : Thread: "+ Thread.currentThread().getName()));
		
	}

	private static void method2() throws InterruptedException {
		
		System.out.println("Invoke method2");
		
		Observable<String> source = Observable.just("BMW", "Mercedes-Benz", "Audi", "Ford")
				.subscribeOn(Schedulers.single());
		
		source.subscribe(e -> System.out.println("Observer1: " + task(e)));
		source.subscribe(e -> System.out.println("Observer2: " + task(e)));
		source.subscribe(e -> System.out.println("Observer3: " + task(e)));
		source.subscribe(e -> System.out.println("Observer4: " + task(e)));
		source.subscribe(e -> System.out.println("Observer5: " + task(e)));
		source.subscribe(e -> System.out.println("Observer6: " + task(e)));
		source.subscribe(e -> System.out.println("Observer7: " + task(e)));
		source.subscribe(e -> System.out.println("Observer8: " + task(e)));
		source.subscribe(e -> System.out.println("Observer9: " + task(e)));
		source.subscribe(e -> System.out.println("Observer10: " + task(e)));
		source.subscribe(e -> System.out.println("Observer11: " + task(e)));
		source.subscribe(e -> System.out.println("Observer12: " + task(e)));
		source.subscribe(e -> System.out.println("Observer13: " + task(e)));
		source.subscribe(e -> System.out.println("Observer14: " + task(e)));
		source.subscribe(e -> System.out.println("Observer15: " + task(e)));

	}
	
	
	private static String task(String valueSource) throws InterruptedException {
		Thread.sleep(2000);
		return "--> valueSource: "+ valueSource+ " - single Done By : "+ Thread.currentThread().getName();
	}
	

	
	


}
