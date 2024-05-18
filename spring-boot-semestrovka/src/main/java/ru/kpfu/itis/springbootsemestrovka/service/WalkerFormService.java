package ru.kpfu.itis.springbootsemestrovka.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.springbootsemestrovka.dto.req.WalkerFormRequest;
import ru.kpfu.itis.springbootsemestrovka.dto.resp.WalkerFormResponse;
import ru.kpfu.itis.springbootsemestrovka.entity.UserEntity;
import ru.kpfu.itis.springbootsemestrovka.entity.WalkerFormEntity;
import ru.kpfu.itis.springbootsemestrovka.exception.WalkerFormNotFoundServiceException;
import ru.kpfu.itis.springbootsemestrovka.mapper.WalkerFormMapper;
import ru.kpfu.itis.springbootsemestrovka.repository.WalkerFormRepository;
import ru.kpfu.itis.springbootsemestrovka.security.user.Role;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WalkerFormService {

    private final WalkerFormRepository walkerFormRepository;
    private final WalkerFormMapper walkerFormMapper;
    private final UserService userService;

    public void sendWalkerRequest(UserEntity user, WalkerFormRequest walkerFormRequest) {
        WalkerFormEntity walkerFormEntity = walkerFormMapper.toEntity(walkerFormRequest);
        walkerFormEntity.setUser(user);

        walkerFormRepository.save(walkerFormEntity);
    }

    public List<WalkerFormResponse> getRequests() {
        return walkerFormMapper.toListResponse(walkerFormRepository.getAllUnCheckedForms());
    }

    public void approveForm(Long walkerFormId) {
        WalkerFormEntity walkerForm = getWalkerFormById(walkerFormId);
        UserEntity userEntity = walkerForm.getUser();
        userService.addRole(userEntity, Role.WALKER);

        walkerFormRepository.delete(walkerForm);
    }

    public void rejectForm(Long walkerFormId){
        walkerFormRepository.updateCheckedField(walkerFormId);
    }

    private WalkerFormEntity getWalkerFormById(Long walkerFormId){
        return walkerFormRepository.getWalkerFormEntityById(walkerFormId)
                .orElseThrow(() -> new WalkerFormNotFoundServiceException(walkerFormId));

    }
}
