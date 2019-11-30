package elevenbuy;

import elevencount.itemBean;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class countReducer extends Reducer<itemBean, LongWritable,itemBean,LongWritable> {

    LongWritable v=new LongWritable();

    @Override
    protected void reduce(itemBean key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        long sum_focus=0;
        for(LongWritable val:values){
            sum_focus=sum_focus+val.get();
        }
        v.set(sum_focus);
        context.write(key,v);

    }
}
