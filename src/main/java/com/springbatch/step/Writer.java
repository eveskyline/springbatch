package com.springbatch.step;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * @author raogs
 * @version 1.0
 * @date 2020/9/7 17:44
 */
public class Writer implements ItemWriter<String> {
    @Override
    public void write(List<? extends String> list) throws Exception {
        for (String s : list) {
            System.out.println("Writing the data " + s);
        }
    }
}
