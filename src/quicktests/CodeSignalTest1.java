package quicktests;

public class CodeSignalTest1 {
    String solution(String s) {
        String result = s;
        if(result.length() == 0 ){
            return result;
        }

        for(int i=1;i <= s.length();i++){
            String str = s.substring(0,i);
            if(isPalin(str)){
                if(str.length() > 2){
                    result=str.substring(i);
                    System.out.println(result);
                    solution(s.substring(i));
                }
            }
        }
        return result;
    }

    public boolean isPalin(String s){
        StringBuffer sb = new StringBuffer();
        sb.append(s);
        if(s.length() > 0 && sb.reverse().toString().equals(s)){
            sb.delete(0,s.length());
            return true;
        }else{
            sb.delete(0,s.length());
            return false;
        }
    }

    public static void main(String [] args){
        CodeSignalTest1 cs = new CodeSignalTest1();
        System.out.println("Result=>"+cs.solution("aaacodedocaff"));
    }
}
