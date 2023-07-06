package com.ecomerce.app.ecommerceapp.service;

import com.google.common.eventbus.Subscribe;
import reactor.core.publisher.Flux;

public class Test {
    public static void main(String[] args) {
        Flux<Integer> fluxInt=Flux.just(1,10,100).log();
        fluxInt.reduce(Integer::sum).subscribe(sum ->System.out.printf("the sum is  : %d\n",sum));
        fluxInt.reduce(Integer::max).subscribe(max-> System.out.printf("maximum is : %d",max));
    }


}
