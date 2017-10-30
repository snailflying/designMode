package com.aaron.design.filter;


import com.aaron.design.filter.domain.Input;
import com.aaron.design.filter.domain.Output;

/**
 * Author：Aaron
 * Time：30/09/2017:4:05 PM
 */
public class Filter2 implements IFilter {
    @Override
    public Output execute(Chain chain) {

        RealChain realChain  = (RealChain) chain;
        Input input = chain.input();

        return realChain.proceed(input);
    }
}
