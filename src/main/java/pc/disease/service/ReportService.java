package pc.disease.service;

import pc.disease.entity.Report;
import com.baomidou.mybatisplus.extension.service.IService;
import pc.utils.PcResultutil;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lazymxh
 * @since 2022-04-15 10:58:01
 */
public interface ReportService extends IService<Report> {

    PcResultutil ist(Report report);


    PcResultutil exi(String userid, String conid);

    PcResultutil sel();

    PcResultutil getnum();
}
