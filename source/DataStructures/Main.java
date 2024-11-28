package source.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> stack = new ArrayList<>();
    static List<String> answer = new ArrayList<>();
    static List<Integer> example = new ArrayList<>();
    static int index = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sRepeatTime = br.readLine();
        int size = Integer.parseInt(sRepeatTime);

        //list init
        for (int i = 0 ; i < size ; i++){
            String el = br.readLine();
            example.add(Integer.parseInt(el));
        }
        //
        int now = 1;
        while(example.size() != stack.size()){
            if (validatior(now)){
                push(now);
                now++;
            }else if (!validatior(now)){
                pop();
                now--;
            }
        }

        for (String answer : answer){
            System.out.println(answer);
        }
    }
    public static void push(int request){
        stack.add(request);
        answer.add("+");
    }
    public static void pop(){
        stack.remove(stack.size()-1);
        answer.add("-");
        index++;
    }
    public static boolean validatior(int now){
//        System.out.println(example.get(index));
//        System.out.println(now);
        if(stack.isEmpty()){
            return true;
        }else if (example.get(index) != now){
            return true;
        }else if(example.get(index) == now){
            return false;
        }

        return false;
    }
}
