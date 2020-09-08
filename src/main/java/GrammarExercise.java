import java.util.*;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.stream.Collectors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        Scanner scanner = new Scanner(System.in);
        String firstWordList = scanner.nextLine();
        String secondWordList = scanner.nextLine();

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //按要求输出到命令行
        String resultstr = String.join(",",result);

        System.out.println(resultstr);

    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        if(!isAlphabetic(firstWordList)||!isAlphabetic(secondWordList)) {
            throw new RuntimeException("input not");
        };
        String[] firstWordarr;
        firstWordarr = firstWordList.toUpperCase().replaceAll("([A-Za-z])([A-Za-z])", "$1 $2 ").split(",");
        String[] secondWordarr;
        secondWordarr = secondWordList.toUpperCase().replaceAll("([A-Za-z])([A-Za-z])", "$1 $2 ").split(",");

        List<String> firstList = Arrays.asList(firstWordarr);
        List<String> secondList = Arrays.asList(secondWordarr);

        List<String> list = new ArrayList<>();
        for (String s : firstList) {
            if (secondList.contains(s)) {
                list.add(s);
            }
        }
        Collections.sort(list);
        return list;
        }
    }
    private static boolean isAlphabetic(String s){
        Pattern p = Pattern.compile("^[A-Za-z]*([A-Za-z]+[,])*([A-Za-z]+)$");
        Matcher m = p.matcher(s);
        return m.matches();
    }

}
