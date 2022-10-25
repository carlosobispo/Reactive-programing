package com.nttdata.sesion4.operators;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SubscribeOnOperator {

	public static void main(String[] args) throws InterruptedException {
		
		Observable.just("BMW", "Mercedes-Benz", "Audi", "Ford")
		.subscribeOn(Schedulers.io())
		.map(value -> value.toUpperCase())
		.doOnNext(e -> System.out.println(Thread.currentThread().getName()))
		.subscribeOn(Schedulers.computation())
		.filter(e -> e.startsWith("A"))
		.subscribe(result -> print(result));
		
		Thread.sleep(10000);
		
	}
	
	
	private static void print(String valueSource){
		System.out.println("--> valueSource: "+ valueSource+ " - Printed By : "+ Thread.currentThread().getName()); 
	}
	

}
