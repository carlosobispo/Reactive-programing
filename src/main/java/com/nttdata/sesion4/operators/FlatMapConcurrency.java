package com.nttdata.sesion4.operators;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FlatMapConcurrency {

	public static void main(String[] args) throws InterruptedException {
		
		Observable.just("BMW", "Mercedes-Benz", "Audi", "Ford") 
		.map(value -> value.toUpperCase())
		.flatMap(value -> Observable.just(value)
				.subscribeOn(Schedulers.computation())
				.map(srt -> comnpute(srt)))
		
		.subscribe(result -> System.out.println(result + " - Printed By : "+Thread.currentThread().getName()));

		Thread.sleep(20000);
		
	}
	
	
	private static String comnpute(String valueSource) throws InterruptedException{
		Thread.sleep(3000);
		return "valueSource: "+ valueSource ; 
	}
	

}
