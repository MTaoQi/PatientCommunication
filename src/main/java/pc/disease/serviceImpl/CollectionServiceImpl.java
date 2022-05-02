package pc.disease.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import pc.disease.entity.Collection;
import pc.disease.entity.Communication;
import pc.disease.mapper.CollectionMapper;
import pc.disease.mapper.CommunicationMapper;
import pc.disease.service.CollectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pc.utils.PcResultutil;
import pc.utils.TimeUtil;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lazymxh
 * @since 2022-03-27 12:58:11
 */
@Service
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, Collection> implements CollectionService {
    @Autowired
    CollectionMapper collectionMapper;
    @Autowired
    CommunicationMapper communicationMapper;
    @Override
    //收藏
    public PcResultutil iscollection(String userid, String communicationid) {
      int num = Math.toIntExact(collectionMapper.selectCount(new QueryWrapper<Collection>().eq("userid", userid).eq("communicationid", communicationid)));
      if(num == 1){
          collectionMapper.delete(new QueryWrapper<Collection>().eq("userid",userid).eq("communicationid",communicationid));
      }
      else{
          Collection collection = new Collection();
          collection.setUserid(userid);
          collection.setCommunicationid(communicationid);
          collection.setTime(new TimeUtil().getFormatDateForSix());
          collectionMapper.insert(collection);
      }
          //交流是否存在
      int count= Math.toIntExact(collectionMapper.selectCount(new QueryWrapper<Collection>().eq("communicationid", communicationid)));
        Communication communication = new Communication();
        communication.setId(communicationid);
        communication.setNumcollection(count);
        communicationMapper.update(communication,new QueryWrapper<Communication>().eq("id",communicationid));

        return PcResultutil.ok(count);
    }

    @Override
    //是否收藏
    public PcResultutil istcollection(String userid, String communicationid) {
       int num= Math.toIntExact(collectionMapper.selectCount(new QueryWrapper<Collection>().eq("userid", userid).eq("communicationid", communicationid)));
       if(num!=1){
           return PcResultutil.ok("no");
       }
       return PcResultutil.ok("yes");
    }
}
