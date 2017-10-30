package com.aaron.design.filter;


import com.aaron.design.filter.domain.Input;
import com.aaron.design.filter.domain.Output;

/**
 * Author：Aaron
 * Time：30/09/2017:1:58 PM
 */
public interface IFilter {
    public Output execute(Chain chain);

    interface Chain{
        Input input();
        Output proceed(Input input);
    }

}
