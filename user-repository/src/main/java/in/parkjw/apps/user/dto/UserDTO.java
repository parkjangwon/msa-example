package in.parkjw.apps.user.dto;

import in.parkjw.apps.core.dto.DTO;
import lombok.*;

import javax.validation.constraints.NotNull;

public class UserDTO {

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class Create implements DTO {

        @NotNull
        String email;

        @NotNull
        String password;

        @NotNull
        String name;

        @NotNull
        boolean isActive;

    }

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class View implements DTO {

        long id;
        String email;
        String password;
        String name;
        boolean isActive;

    }

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class Update {

        @NotNull
        String email;

        @NotNull
        String password;

        @NotNull
        String name;

        @NotNull
        boolean isActive;

    }
}
