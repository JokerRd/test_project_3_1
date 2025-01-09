package dto;

public class ResultSaveInformationDto {

    Long id;
    boolean isSuccess;
    String message;

    public ResultSaveInformationDto(Long id, boolean isSuccess, String message) {
        this.id = id;
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getMessage() {
        return message;
    }
}
