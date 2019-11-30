package popularitem;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class countMapper extends Mapper<LongWritable, Text,longBean,itemBean > {

    //Text v=new Text();
    longBean k=new longBean();
    itemBean v=new itemBean();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //获取一行
        String line=value.toString();
        //分割，按\t分
        String[] fields=line.split("\t");
        //封装对象
        long focus_num=Long.parseLong(fields[2]);
        long item_it=Long.parseLong(fields[0]);
        String province=fields[1];
        v.setItem_id(item_it);
        v.setProvince(province);
        k.setFocusNum(focus_num);

        //写出
        context.write(k,v);
    }
}
