package com.macro.mall.demo.demo.common;

/**
 * 缓存配置类
 * @Author gaohao
 * @Date 2020/4/29 15:08
 */
public interface RedisConfig {

    /** 登录token前缀 */
    String USER_TOKEN = "userToken:userToken-";

    /** 登录token有效期前缀 */
    Integer USER_TOKEN_TIME = 2;

    /** 权限URL */
    String USER_PERMISSION_URL = "user:permissionUrl-";

    /** 验证码前缀 */
    String WEB_LOGIN_CODE = "webLoginCode:";

    /** 平台类型 */
    String PLAT_TYPE = "dataDic:platType";

    /** 采集任务状态 */
    String TASK_STATUS = "dataDic:taskStatus";

    /** 带货品类 */
    String STAR_CATEGORY = "starCategory";

    /** 区域信息 */
    String AREA_INFO = "areaInfo";

    /** 区域信息 */
    String AREA_INFO_ALL = "areaInfoAll";

    /** 区域信息 */
    String AREA_INFO_ALL_DATA = "areaInfoAllData";

    /** 企业分类信息 */
    String COMPANY_INDUSTRY_INFO = "companyIndustryInfo";

    /** 字典信息 */
    String DATA_DIC = "dataDic:";

    /** 监测结果审核状态 */
    String MONITORING_RESULTS_CHECK_STATUS = "dataDic:monitoringResultsCheckStatus";

    /** 转译锁 */
    String TASK_LFASR_STATUS = "task:task_lfasr_status";


    /** 存证编码前缀 */
    String CODE_PREFIX = "count:codePrefix-";

    /** 监测结果文件名编号前缀 */
    String MONITOR_EXCEL_PREFIX = "count:monitorExcelPrefix-";

    /** 存证文件名编号前缀 */
    String BLOCK_EXCEL_PREFIX = "count:blockExcelPrefix-";

    /** 管辖单位 */
    String JURISDICTION_UNIT = "jurisdictionUnit";

    /** 管辖单位 */
    String JURISDICTION_UNIT_ALL = "jurisdictionUnitAll";

    /** 行业类型 */
    String INDUSTRY_CATEGORY_ALL = "industryCategoryAll";

    /** 上传路径 */
    String UPLOAD_FILE = "uploadPath:";

    /** 任务失败前缀 */
    String TASK_ERROR = "taskError:";

    /** 任务转译等待前缀 */
    String TASK_TO_TEXT_WAIT = "taskToTextWait:";

    /** 切片任务等待前缀 */
    String SECTION_TASK_WAIT = "taskToTextWait:";

    /************************* 大屏数据 *************************/
    /** 主播违规排名 */
    String VIOLATING_ANCHOR_RANKING = "realTimeData:violatingAnchorRanking";
    /** 违禁词排行 */
    String PROHIBITED_WORDS_RANKING = "realTimeData:prohibitedWordsRanking";
    /** 直播违规平台分布 */
    String LIVE_ILLEGAL_CLUES_PLATFORMS_DISTRIBUTION = "realTimeData:liveIllegalCluesPlatformsDistribution";
    /** 互联网广告违规平台分布 */
    String INTERNET_AD_ILLEGAL_CLUES_PLATFORMS_DISTRIBUTION = "realTimeData:internetAdIllegalCluesPlatformsDistribution";
    /** 违法线索数 */
    String ILLEGAL_CLUES_NUMBER = "realTimeData:illegalCluesNumber";
    /** 违法线索走势 */
    String ILLEGAL_CLUES_TREND = "realTimeData:illegalCluesTrend";
    /** 违法线索审核走势 */
    String ILLEGAL_CLUES_AUDIT_TREND = "realTimeData:illegalCluesAuditTrend";
    /** 城市违法线索数 */
    String CITY_ILLEGAL_CLUES_NUMBER = "realTimeData:cityIllegalCluesNumber";
    /********************************************************/

    /** 派发平台 */
    String RECEIVE_PLATFORM = "receivePlatform";

    /** 再匹配关键字 */
    String REMATCH_KEYWORD = "rematchKeyword:";
}
