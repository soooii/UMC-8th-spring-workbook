package com.hufs.umc5.validation.validator;

import com.hufs.umc5.apiPayload.code.status.ErrorStatus;
import com.hufs.umc5.domain.enums.MissionStatus;
import com.hufs.umc5.domain.mapping.MemberMission;
import com.hufs.umc5.dto.MemberMissionRequestDTO;
import com.hufs.umc5.repository.MemberMissionRepository.MemberMissionRepository;

import com.hufs.umc5.validation.annotation.IfComplete;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IfCompleteValidator implements ConstraintValidator<IfComplete, MemberMissionRequestDTO> {
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public void initialize(IfComplete constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MemberMissionRequestDTO dto, ConstraintValidatorContext context) {

        MemberMission memberMission = memberMissionRepository.findMemberMissionByMemberIdAndMissionId(dto.getMemberId(), dto.getMissionId());

        if(memberMission.getStatus() == MissionStatus.COMPLETE){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.ALLREADY_COMPLETE.toString()).addConstraintViolation();
            return false;
        }

        return true;
    }
}
