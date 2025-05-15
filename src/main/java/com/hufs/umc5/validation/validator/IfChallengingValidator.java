package com.hufs.umc5.validation.validator;

import com.hufs.umc5.apiPayload.code.status.ErrorStatus;
import com.hufs.umc5.domain.enums.MissionStatus;
import com.hufs.umc5.domain.mapping.MemberMission;
import com.hufs.umc5.dto.MemberMissionRequestDTO;
import com.hufs.umc5.repository.MemberMissionRepository.MemberMissionRepository;
import com.hufs.umc5.validation.annotation.IfChallenging;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;


@Component
@RequiredArgsConstructor
public class IfChallengingValidator implements ConstraintValidator<IfChallenging, MemberMissionRequestDTO> {
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public void initialize(IfChallenging constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MemberMissionRequestDTO dto, ConstraintValidatorContext context) {

        MemberMission memberMission = memberMissionRepository.findMemberMissionByMemberIdAndMissionId(dto.getMissionId(), dto.getMemberId());
        if(memberMission.getStatus() == MissionStatus.CHALLENGING){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.ALLREADY_CHALLENGING.toString()).addConstraintViolation();
            return false;
        }

        return true;
    }
}
