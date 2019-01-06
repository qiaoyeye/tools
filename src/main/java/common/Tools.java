package common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Tools{

    static Logger logger = LogManager.getLogger( Tools.class );
    public static void test(){

        logger.info( "执行结果0" );
        logger.error( "执行结果1" );
        logger.debug( "执行结果2" );
        logger.warn( "执行结果3" );
    }

   public static void main(String[] args){
        test();
   }
}
