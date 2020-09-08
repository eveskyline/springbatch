package com.springbatch.step;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 * @author raogs
 * @version 1.0
 * @date 2020/9/7 17:37
 */
public class Reader implements ItemReader<String> {

    private String[] message = {"ming", "mingming", "mingmingming"};

    private int count = 0;

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(count < message.length){
            return message[count++];
        }else{
            return null;
        }
    }
}
