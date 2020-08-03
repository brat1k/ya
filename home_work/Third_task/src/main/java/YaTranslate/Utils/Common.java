package YaTranslate.Utils;

import static java.lang.System.out;

    public class Common {
        public static void sleepSec(int s) {
            {
                try
                {
                    Thread.sleep(s*1000);
                }catch(InterruptedException e){
                    out.println(e);}
            }
        }
}
