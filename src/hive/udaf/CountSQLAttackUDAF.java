package hive.udaf;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDAF;
import org.apache.hadoop.hive.ql.exec.UDAFEvaluator;
import org.apache.hadoop.hive.ql.metadata.HiveException;

/**
 * Created by suyu on 17-4-2.
 */
@Description(name = "Count", value = "_FUNC(double) - computes sum", extended = "select SQLSumFunc(value) from table")
public class CountSQLAttackUDAF extends UDAF {
/*
    // Define Logging
    static final Log LOG = LogFactory.getLog(CountSQLAttackUDAF.class.getName());



    public static class CountSQLUDAFEvaluator implements UDAFEvaluator {

        /**
         * Use Column class to serialize intermediate computation
         * This is our groupByColumn
         */


        private int col = null;

        public CountSQLUDAFEvaluator() {
            super();
            init();
        }
// A - Initalize evaluator - indicating that no values have been
        // aggregated yet.

        public void init() {
            LOG.debug("Initializeuator");
            col = new Column();
        }

        // B- Iterate every time there is a new value to be aggregated
        public boolean iterate(String value) throws HiveException {
            LOG.debug("Iterating each value for aggregation");
            if (col == null)
                throw new HiveException("Item is not initialized");
            col.sum = col.sum +calculate( value);

            return true;
        }
        // C - Called when Hive wants partially aggregated results.
        public Column terminatePartial() {
            LOG.debug("Returnially aggregated results");
            return col;
        }
        // D - Called when Hive decides to combine one partial aggregation with another
        public boolean merge(Column other) {
            LOG.debug("mergingombining partial aggregation");
            if(other == null) {
                return true;
            }
            col.sum += other.sum;

            return true;
        }
        // E - Called when the final result of the aggregation needed.
        public double terminate(){
            LOG.debug("Atend of last record of the group - returning final result");
            return col.sum;
        }

        public  int calculate(String str) {
            int result = 0;

            String[] tokens= new String[21];
            tokens[0] = "user()";
            tokens[1] = "\"";
            tokens[2] = "\'";
            tokens[3] = "--";
            tokens[4] = "/*";
            tokens[5] = "/*!";
            tokens[6] = "';";
            tokens[7] = "-1' or";
            tokens[8] = "-1 or";
            tokens[9] = "order by";
            tokens[10] = "b/**/y";
            tokens[11] = "/*!by*/";
            tokens[12] = "IF(SUBSTR(@@version";
            tokens[13] = "and sleep(";
            tokens[14] = "' and sleep(";
            tokens[15] = "waitfor delay '";
            tokens[16] = "@@version";
            tokens[17] = "having 1=1--";
            tokens[18] = "' and";
            tokens[19] = "' || '' || '";
            tokens[20] = "' exec master..xp_cmdshell 'vol'--";

            for (String s: tokens
                    ) {
                if(str.contains(s))
                    return 1;
            }
            return result;
        }
*/
    }

    public static void main(String[] args) {
        CountSQLAttackUDAF test = new CountSQLAttackUDAF();
        System.out.println(("select * from test order by "));
    }
}
