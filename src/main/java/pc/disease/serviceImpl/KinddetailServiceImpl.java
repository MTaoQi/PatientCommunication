package pc.disease.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import pc.disease.entity.Collection;
import pc.disease.entity.Kinddetail;
import pc.disease.entity.cell;
import pc.disease.mapper.KinddetailMapper;
import pc.disease.service.KinddetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pc.utils.PcResultutil;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lazymxh
 * @since 2022-04-02 01:54:59
 */
@Service
public class KinddetailServiceImpl extends ServiceImpl<KinddetailMapper, Kinddetail> implements KinddetailService {
    @Autowired
    KinddetailMapper kinddetailMapper;

    @Override
    //插入
    public PcResultutil istKindDetail(Kinddetail kinddetail) {
        kinddetailMapper.insert(kinddetail);
        return PcResultutil.ok(kinddetail);
    }
     //查询
    @Override
    public PcResultutil selKindDetail(String minkind) {
        Kinddetail kinddetail = kinddetailMapper.selectOne(new QueryWrapper<Kinddetail>().eq("minkind", minkind));
        return PcResultutil.ok(kinddetail);
    }
    //搜索疾病
    @Override
    public PcResultutil searchDisease(String minkind) {
        Kinddetail kinddetail = kinddetailMapper.selectOne(new QueryWrapper<Kinddetail>().like("minkind", minkind));
        return PcResultutil.ok(kinddetail);
    }
    //统计出现次数
    @Override
    public PcResultutil num() {
        List<Kinddetail> list = kinddetailMapper.selectList(new QueryWrapper<Kinddetail>());
        String str="";

        for (int i = 0; i < list.size(); i++) {
        str=str+list.get(i).getSymptom();
        }
        String [] s=str.split("，");
        Map<String, Integer> map = new HashMap<>();
        for(String c: s){
            //当c不存在于map
            if(!map.containsKey(c)){
                map.put(c,1);
            }
            else{
                map.put(c,map.get(c)+1);
            }
        }
        //map.keySet()所有键的集合
        ArrayList<cell> cells = new ArrayList<>();
        for(String key:map.keySet()){
            cells.add(new cell(key,map.get(key)));
        }
        //匿名内部类 new Comparator<cell>()
        Collections.sort(cells, new Comparator<cell>() {
            @Override
            public int compare(cell o1, cell o2) {
                return o2.getNum()- o1.getNum();
            }
        });
        return PcResultutil.ok(cells);
    }


}
