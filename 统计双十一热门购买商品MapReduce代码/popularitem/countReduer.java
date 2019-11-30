package popularitem;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class countReduer extends Reducer<longBean,itemBean,itemBean,LongWritable> {

    @Override
    protected void reduce(longBean key, Iterable<itemBean> values, Context context) throws IOException, InterruptedException {
        LongWritable k=new LongWritable();
        for(itemBean value:values){
            k.set(key.getFocusNum());
            context.write(value,k);
        }
    }

}
