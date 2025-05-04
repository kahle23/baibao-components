package baibao.plugin.service.basic.api.log.service;

import baibao.db.jdbc.mybatisplus.base.BaseService;
import kunlun.io.fileprocessor.ProcResult;
import org.springframework.web.multipart.MultipartFile;
import baibao.plugin.service.basic.api.log.pojo.entity.OpLog;
import baibao.plugin.service.basic.api.log.pojo.param.OpLogAddParam;
import baibao.plugin.service.basic.api.log.pojo.param.OpLogEditParam;
import baibao.plugin.service.basic.api.log.pojo.query.OpLogQuery;
import baibao.plugin.service.basic.api.log.pojo.result.OpLogResult;

/**
 * 操作日志表的服务类.
 *
 * @author Kahle
 * @since 2025-05-04
 */
public interface OpLogService extends BaseService<OpLog
        , OpLogAddParam, OpLogEditParam, OpLogQuery, OpLogResult> {

}
