/*
 * <summary></summary>
 * <author>He Han</author>
 * <email>hankcs.cn@gmail.com</email>
 * <create-date>2014/12/7 19:25</create-date>
 *
 * <copyright file="DemoChineseNameRecoginiton.java" company="上海林原信息科技有限公司">
 * Copyright (c) 2003-2014+ 上海林原信息科技有限公司. All Right Reserved+ http://www.linrunsoft.com/
 * This source is subject to the LinrunSpace License. Please contact 上海林原信息科技有限公司 to get more information.
 * </copyright>
 */
package com.hankcs.demo;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.mining.word.WordInfo;
import com.hankcs.hanlp.summary.TextRankKeyword;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 关键词提取
 * @author hankcs
 */
public class DemoKeyword
{
    public static void main(String[] args)
    {
        String content = "程序员(英文Programmer)是从事程序开发、维护的专业人员。" +
                "一般将程序员分为程序设计人员和程序编码人员，" +
                "但两者的界限并不非常清楚，特别是在中国。" +
                "软件从业人员分为初级程序员、高级程序员、系统" +
                "分析员和项目经理四大类。";
        List<String> keywordList = HanLP.extractKeyword(content, 5);
        System.out.println(keywordList);
    }

    @Test
    public void test(){
        String content = "程序员(英文Programmer)是从事程序开发、维护的专业人员。" +
            "一般将程序员分为程序设计人员和程序编码人员，" +
            "但两者的界限并不非常清楚，特别是在中国。" +
            "软件从业人员分为初级程序员、高级程序员、系统" +
            "分析员和项目经理四大类。";
        List<String> keywordList = HanLP.extractKeyword(content, 5);
        System.out.println(keywordList);





    }
//public static final String file="D:\\CODE\\github\\chachong\\java\\fenci\\HanLP\\HanLP-1.x\\HanLP-1.x\\src\\ruanjian.txt";
    public static final String file="D:\\CODE\\github\\chachong\\java\\fenci\\HanLP\\HanLP-1.x\\HanLP-1.x\\src\\yingjian.txt";

    /****
 * 分词
 *
 * **/

    @Test
    public void generalWords() throws IOException {
        BufferedReader read = new BufferedReader(new FileReader(file));
        List<WordInfo>   wlist=HanLP. extractWords(read, 100000);
        Set<WordInfo> set=new HashSet<>();
        for (WordInfo str:wlist
             ) {
                set.add(str);
                System.out.println(str.text+","+str.frequency+","+str.entropy);

        }
        System.out.println(set.size());

    }

    @Test
    public void hash(){
        String text = null;
        try {
            text = getStrFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> phraseList = HanLP.extractPhrase(text, 2000);
        for (String str:phraseList
             ) {

        }
        System.out.println(phraseList);
    }


    private String getStrFromFile() throws IOException {

        BufferedReader read = new BufferedReader(new FileReader(file));
        String s;
        StringBuffer sb = new StringBuffer();
        while((s=read.readLine()) != null){
            sb.append(s+"\n");
        }
        read.close();
        return sb.toString();
    }
}
