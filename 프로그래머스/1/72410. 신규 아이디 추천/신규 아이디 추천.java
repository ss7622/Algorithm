class Solution {
    public String solution(String new_id) {
        char[] rec = new_id.toCharArray();
        for(int i=0;i<rec.length;i++){
            if(Character.isUpperCase(rec[i])){
                rec[i] = Character.toLowerCase(rec[i]);
            }
        }
        
        for(int i=0;i<rec.length;i++){
            if(Character.isDigit(rec[i]) || rec[i] == '-' || rec[i] == '_' || rec[i] == '.' ||Character.isLowerCase(rec[i])){
                continue;
            }
            rec[i] = '?';
        }
        rec = new String(rec).replace("?","").toCharArray();
        
        for(int i=0;i<rec.length;i++){
            if(rec[i] == '.'){
                for(int j=i+1;j<rec.length;j++){
                    if(rec[j] != '.'){
                        break;
                    }
                    rec[j] = '?';
                }
            }
        }
        if(rec.length > 0 && rec[0] == '.'){
            rec[0] = '?';
        }
        if(rec.length > 0 && rec[rec.length-1] == '.'){
            rec[rec.length-1] = '?';
        }

        rec = new String(rec).replace("?","").toCharArray();
        
        if(rec.length == 0){
            rec = new String("a").toCharArray();
        }
        if(rec.length > 15){
            for(int i=15;i<rec.length;i++){
                rec[i] = '?';
            }
        }
        rec = new String(rec).replace("?","").toCharArray();

        if(rec.length > 0 && rec[rec.length-1] == '.'){
            rec[rec.length-1] = '?';
        }

        rec = new String(rec).replace("?","").toCharArray();
        
        StringBuilder sb = new StringBuilder();
                
        if(rec.length < 3){
            for(int i=0;i<rec.length;i++){
                sb.append(rec[i]);
            }
            for(int i=rec.length;i<3;i++){
                sb.append(rec[rec.length-1]);
            }
            return sb.toString();
        }
        
        
        return new String(rec);
    }
}