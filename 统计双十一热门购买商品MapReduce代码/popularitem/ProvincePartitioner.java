package popularitem;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class ProvincePartitioner extends Partitioner<longBean,itemBean> {
    @Override
    public int getPartition(longBean key, itemBean value, int i) {
        String provin=value.getProvince();
        int partition=34;
        if("安徽".equals(provin)){
            partition=0;
        }else if("澳门".equals(provin)){
            partition=1;
        }else if("北京市".equals(provin)){
            partition=2;
        }else if("福建".equals(provin)){
            partition=3;
        }else if("甘肃".equals(provin)){
            partition=4;
        }else if("广东".equals(provin)){
            partition=5;
        }else if("广西".equals(provin)){
            partition=6;
        }else if("贵州".equals(provin)){
            partition=7;
        }else if("海南".equals(provin)){
            partition=8;
        }else if("河北".equals(provin)){
            partition=9;
        }else if("河南".equals(provin)){
            partition=10;
        }else if("黑龙江".equals(provin)){
            partition=11;
        }else if("湖北".equals(provin)){
            partition=12;
        }else if("湖南".equals(provin)){
            partition=13;
        }else if("吉林".equals(provin)){
            partition=14;
        }else if("江苏".equals(provin)){
            partition=15;
        }else if("江西".equals(provin)){
            partition=16;
        }else if("辽宁".equals(provin)){
            partition=17;
        }else if("内蒙古".equals(provin)){
            partition=18;
        }else if("宁夏".equals(provin)){
            partition=19;
        }else if("青海".equals(provin)){
            partition=20;
        }else if("山东".equals(provin)){
            partition=21;
        }else if("山西".equals(provin)){
            partition=22;
        }else if("陕西".equals(provin)){
            partition=23;
        }else if("上海市".equals(provin)){
            partition=24;
        }else if("四川".equals(provin)){
            partition=25;
        }else if("台湾".equals(provin)){
            partition=26;
        }else if("天津市".equals(provin)){
            partition=27;
        }else if("西藏".equals(provin)){
            partition=28;
        }else if("香港".equals(provin)){
            partition=29;
        }else if("新疆".equals(provin)){
            partition=30;
        }else if("云南".equals(provin)){
            partition=31;
        }else if("浙江".equals(provin)){
            partition=32;
        }else if("重庆市".equals(provin)){
            partition=33;
        }
        return partition;
    }
}
