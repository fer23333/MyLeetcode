//考察正则表达式
//对于metacharacters 对计算机和正则有特殊意义的字符 要用两个antislash"\\" 
//Java regular expression use \\, instead of \, to escape metacharacter such as <([{\^-=$!|]})?*+.>
//https://docs.oracle.com/javase/tutorial/essential/regex/literals.html
//time O(n*m) n: length of emails, m: length of email

    public int numUniqueEmails(String[] emails) {
        if(emails == null || emails.length  == 0){
            return 0;
        }
        Set<String> set = new HashSet<>();
        for(String email : emails){
            String[] parts = email.split("@");
            String[] local = parts[0].split("\\+");
            String template = local[0].replace(".", "") + parts[1];
            set.add(template);
        }
        return set.size();
    }
    
    
