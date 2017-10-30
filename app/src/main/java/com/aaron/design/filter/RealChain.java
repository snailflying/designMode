package com.aaron.design.filter;


import com.aaron.design.filter.domain.Input;
import com.aaron.design.filter.domain.Output;

import java.util.List;

/**
 * Author：Aaron
 * Time：30/09/2017:4:07 PM
 */
public class RealChain implements IFilter.Chain {
    private final List<IFilter> iFilters;


    private final Input input;
    private final String others;
    private final int index;

    public RealChain(List<IFilter> iFilters, int index, Input input, String others) {
        this.iFilters = iFilters;
        this.index = index;
        this.input = input;
        this.others = others;

    }

    @Override
    public Input input() {
        return input;
    }

    @Override
    public Output proceed(Input input) {
        return proceed(input, others);
    }

    public Output proceed(Input input, String others) {

        RealChain realChain = new RealChain(iFilters,index+1,input,others);
        IFilter iFilter = iFilters.get(index);
        Output output = iFilter.execute(realChain);
        //// TODO: 30/09/2017  other code
        return output;
    }
}
