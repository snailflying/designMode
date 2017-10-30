package com.aaron.design.filter;


import com.aaron.design.filter.domain.Input;
import com.aaron.design.filter.domain.Output;

import java.util.ArrayList;
import java.util.List;

/**
 * Author：Aaron
 * Time：30/09/2017:5:02 PM
 */
public class Client {

    Output getResponse() {
        List<IFilter> iFilters = new ArrayList<>();
        iFilters.add(new Filter1());
        iFilters.add(new Filter2());
        //FinalFilter必须放在最后，截断递归调用
        iFilters.add(new FinalFilter());
        Input originInput = new Input();
        IFilter.Chain chain = new RealChain(iFilters, 0, originInput, "others");
        return chain.proceed(originInput);
    }

}
