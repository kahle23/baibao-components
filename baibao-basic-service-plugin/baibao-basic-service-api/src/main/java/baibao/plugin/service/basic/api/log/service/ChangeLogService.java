package baibao.plugin.service.basic.api.log.service;

import baibao.db.jdbc.mybatisplus.base.BaseService;
import kunlun.io.fileprocessor.ProcResult;
import org.springframework.web.multipart.MultipartFile;
import baibao.plugin.service.basic.api.log.pojo.entity.ChangeLog;
import baibao.plugin.service.basic.api.log.pojo.param.ChangeLogAddParam;
import baibao.plugin.service.basic.api.log.pojo.param.ChangeLogEditParam;
import baibao.plugin.service.basic.api.log.pojo.query.ChangeLogQuery;
import baibao.plugin.service.basic.api.log.pojo.result.ChangeLogResult;

/**
 * 数据变动日志表的服务类.
 *
 * @author Kahle
 * @since 2025-05-04
 */
public interface ChangeLogService extends BaseService<ChangeLog
        , ChangeLogAddParam, ChangeLogEditParam, ChangeLogQuery, ChangeLogResult> {

}
