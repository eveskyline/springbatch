package com.springbatch.step;

import org.springframework.batch.item.ItemProcessor;

/**
 * ItemProcessor对项目的业务逻辑处理的一个抽象, 当ItemReader读取到一条记录之后，ItemWriter还未写入这条记录之前，
 * 我们可以借助ItemProcessor提供一个处理业务逻辑的功能，并对数据进行相应操作。
 * 如果我们在ItemProcessor发现一条数据不应该被写入，可以通过返回null来表示
 * @author raogs
 * @version 1.0
 * @date 2020/9/7 17:41
 */
public class Processor implements ItemProcessor<String, String> {
    @Override
    public String process(String s) throws Exception {
        return s.toUpperCase();
    }
}
