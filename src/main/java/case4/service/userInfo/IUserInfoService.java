package case4.service.userInfo;

import case4.model.entity.UserInfo;
import case4.service.IGeneralService;

public interface IUserInfoService extends IGeneralService<UserInfo> {
    UserInfo findByUserId(Long id);
    Long findUserByUserInfo(Long id);
}
