package com.nttdata.sesion4;

import org.junit.Test;

import io.reactivex.rxjava3.core.Observable;

public class ConcurrencyInRxJava {

	@Test
	public void createObservableTest() {
		
		System.out.println("Init method createObservableTest");
		
		Observable<String> source = Observable.create(
				e ->{
					e.onNext("Hello");
					Thread.sleep(2000);
					e.onNext("RxJava");
					Thread.sleep(2000);
					e.onComplete();
				});
		source.subscribe(e -> System.out.println("Observer1 : "+ e + " : Thread: "+ Thread.currentThread()));
		source.subscribe(e -> System.out.println("Observer2 : "+ e + " : Thread: "+ Thread.currentThread()));
	}


	@Test
	public void createObservable2Test() throws InterruptedException {
		
		System.out.println("Init method createObservable2Test");
		
		Observable<String> source = Observable.create(
				e ->{
					new Thread(()->  {
						e.onNext("Hello");
						
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						e.onNext("RxJava");
						e.onComplete();
					}).start(); 
				});
		
		source.subscribe(e -> System.out.println("Observer1 : "+ e + " : Thread: "+ Thread.currentThread()));
		source.subscribe(e -> System.out.println("Observer2 : "+ e + " : Thread: "+ Thread.currentThread()));
		
		Thread.sleep(5000);
	}
}
