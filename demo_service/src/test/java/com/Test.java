package com;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import utils.Util;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Test.class)
public class Test {


    @org.junit.Test
    public void test1() {
        System.out.println("-------------------------------------------");
        String[] dictionary =  {"i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "man go"};//词典
        String a = "ilikesamsungmobile";
        String b = "ilikeicecreamandmango";
        String[] result = Util.switchSentence(dictionary, a);
        printResult(result);
        result = Util.switchSentence(dictionary, b);
        printResult(result);
        System.out.println("-------------------------------------------");
        String[] dictionary2 =  {"i", "like", "sam", "sung", "samsung", "mobile", "icecream", "man go","mango"};//词典
        result = Util.switchSentence(dictionary2, a);
        printResult(result);
        result = Util.switchSentence(dictionary2, b);
        printResult(result);
        System.out.println("-------------------------------------------");
        String[] dictionary3 =  {"i", "like", "sam", "sung", "samsung", "mobile", "icecream", "man go","mango"};//词典
        String[] dictionaryL = new String[100];
        Util.mergeDictionary(dictionary, dictionary3, dictionaryL);

        result = Util.switchSentence(dictionaryL, a);
        printResult(result);
        result = Util.switchSentence(dictionaryL, b);
        printResult(result);

    }


    private void printResult(String[] result) {
        System.out.print("Output：");
        for (int i = result.length; i>0;i--) {
            if(result[i-1]!=null){
                System.out.print(result[i-1]+" ");
            }
        }
        System.out.println();
    }


}
