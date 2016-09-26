package ejb.converter;


import api.dto.StrumentationDto;
import api.utils.UtilDate;
import model.entity.Strumentation;

/**
 * Created by simon on 31/08/16.
 */
public class StrumentationConverter {

    public static class ToEntity {
        public static SuperConverter<StrumentationDto, Strumentation> toStrumentationEntity =
                dto -> {
                    Strumentation strumentation = new Strumentation();
                    strumentation.setIdStrumentazione(dto.getIdStrumentazione() != null
                            ? Integer.valueOf(dto.getIdStrumentazione())
                            : null);
                    strumentation.setDesStrumentazione(dto.getDesStrumentazione() != null
                            ? dto.getDesStrumentazione()
                            : null);
                    strumentation.setModelloStrumentazione(dto.getModelloStrumentazione() != null
                            ? dto.getModelloStrumentazione()
                            : null);
                    strumentation.setMarcaStrumentazione(dto.getMarcaStrumentazione() != null
                            ? dto.getMarcaStrumentazione()
                            : null);
                    strumentation.setPezzi(dto.getPezzi() != null
                            ? Integer.valueOf(dto.getPezzi())
                            : null);
                    strumentation.setDtAcquisto(dto.getDtAcquisto() != null
                            ? UtilDate.toDate(dto.getDtAcquisto())
                            : null);
                    return strumentation;
                };
    }


    public static class ToDto {
        public static SuperConverter<Strumentation, StrumentationDto> toStrumentationDto =
                entity -> {

                    StrumentationDto dto = new StrumentationDto();
                    dto.setIdStrumentazione(entity.getIdStrumentazione() != null
                            ? entity.getIdStrumentazione().toString()
                            : null);
                    dto.setDesStrumentazione(entity.getDesStrumentazione() != null
                            ? entity.getDesStrumentazione()
                            : null);
                    dto.setModelloStrumentazione(entity.getModelloStrumentazione() != null
                            ? entity.getModelloStrumentazione()
                            : null);
                    dto.setMarcaStrumentazione(entity.getMarcaStrumentazione() != null
                            ? entity.getMarcaStrumentazione()
                            : null);
                    dto.setPezzi(entity.getPezzi() != null
                            ? entity.getPezzi().toString()
                            : null);
                    dto.setDtAcquisto(entity.getDtAcquisto() != null
                            ? UtilDate.toString(entity.getDtAcquisto())
                            : null);
                    return dto;
                };
    }


}
