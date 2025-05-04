package baibao.plugin.service.basic.api.log.service;

import baibao.db.jdbc.mybatisplus.base.BaseService;
import kunlun.io.fileprocessor.ProcResult;
import org.springframework.web.multipart.MultipartFile;
import baibao.plugin.service.basic.api.log.pojo.entity.RunLog;
import baibao.plugin.service.basic.api.log.pojo.param.RunLogAddParam;
import baibao.plugin.service.basic.api.log.pojo.param.RunLogEditParam;
import baibao.plugin.service.basic.api.log.pojo.query.RunLogQuery;
import baibao.plugin.service.basic.api.log.pojo.result.RunLogResult;

/**
 * 运行日志表的服务类.
 *
 * @author Kahle
 * @since 2025-05-04
 */
public interface RunLogService extends BaseService<RunLog
        , RunLogAddParam, RunLogEditParam, RunLogQuery, RunLogResult> {

}
