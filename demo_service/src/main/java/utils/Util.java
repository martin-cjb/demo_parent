package utils;

public class Util {

     public static String[] switchSentence(String[] dictionary, String a) {
        System.out.println("Input："+a);
        String[] result = new String[100]; //结果数组
        int flag=0;//找到匹配字符串与否的标志
        int flag2 = 0;//判断上一个是否是词典中的词
        int j=0;
        String temp=null;//初始化临时字符串
        while (a.length()>0)
        {
            for(int i = 0;i<a.length();i++)
            {
                temp = a.substring(i);//每次截取掉首个字符
                String isin = isin(dictionary,temp);
                if( isin != null)//如果目标字符串在数组中
                {
                    result[j] = isin;
                    flag = 1;
                    int number = temp.length();
                    a = a.substring(0,a.length()-number);
                    flag2 =1;
                }
            }
            if(flag == 0 && flag2==1)//没有找到匹配字符串并且上一个词是词典中的词
            {
                result[j] = a.substring(a.length()-1,a.length());//将最后一个元素放在result里面
                a = a.substring(0, a.length()-1);//截掉最后一个元素继续循环。
                flag2=0;
            }else if(flag == 0 && flag2==0)//没有找到匹配字符串并且上一个词是词典中的词
            {
                result[j-1] = a.substring(a.length()-1,a.length())+result[j-1];//将最后一个元素放在result里面
                a = a.substring(0, a.length()-1);//截掉最后一个元素继续循环。
                flag2=0;
                j--;
            }
            flag = 0;
            j++;
        }
        return result;
    }

    /*
     * 下面为判断字符串是否在词典中的函数方法,若字典中有空格，展示字典中词
     */

    public static String isin(String[] dictionary,String temp){
        for (int i = 0; i < dictionary.length; i++) {
            if (temp.equals(dictionary[i])) {
                return temp;
            } else if (dictionary[i]!=null&&dictionary[i].contains(" ")) {
                String[] arr = dictionary[i].split(" ");
                String arrto = "";
                for (int j = 0; j < arr.length; j++) {
                    arrto = arrto+arr[j];
                }
                if(temp.equals(arrto)){
                    return dictionary[i];
                }

            }
        }
        return null;
    }



    public static String[] subdivide(String[] dictionary){
        String sp = " ";
        int num = 0;
        for (String s:dictionary) {
            if(s.split(sp).length>1){
                num = num + s.split(sp).length;
            }else{
                num++;
            }
        }
        System.out.println("dictionary长度："+dictionary.length);
        System.out.println("长度："+num);
        String[] d = new String[num];
        int i = 0;
        for(int m = 0; m<dictionary.length;m++){
            System.out.println(dictionary[m]);
            if(dictionary[m].split(sp).length>1){
                String[] arr = dictionary[m].split(sp);
                System.out.println("--------"+arr.length);
                for(int n=0;n<arr.length;n++){
                    d[i]=arr[n];
                    i++;
                }
            }else{
                d[i]=dictionary[m];
                i++;
            }
        }
        return d;
    }

    /*

     * 合并字典，将两个字典合并成一个

     */

    public static void mergeDictionary(String[] dictionary, String[] dictionary3, String[] dictionaryL) {
        for (int i = 0 ;i <dictionary3.length;i++){
            dictionaryL[i]=dictionary3[i];
        }
        int l = dictionary3.length;
        for(int i = 0;i<dictionary.length;i++){
            String s = dictionary[i];
            boolean f = false;
            for(int j = 0;j<dictionary3.length;i++){
                if(s.equals(dictionary3[j])){
                    f = true;
                    break;
                }
            }
            if(f==true){
                break;
            }else{
                dictionaryL[l]=s;
                l++;
            }
        }
    }

}
