package nom.lesha.webApp01.services;


import nom.lesha.webApp01.dao.TransformersDao;
import nom.lesha.webApp01.model.Transformer;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alexey Levchhenko
 */
public class TransformerService {

    private static List<Transformer> transformersList;

    public static Transformer getTransformerById(int id){
        return TransformersDao.getTransformerById(id);
    }


    public static boolean addItem(Transformer transformer) {
        return TransformersDao.addItem(transformer);
    }


    public static HttpServletRequest validateTransformersParams(HttpServletRequest req){
        int inputVoltage = 0;
        int outputVoltage = 0;
        int outputCurrent = 0;
        int mass = 0;
        BigDecimal price = new BigDecimal(0);

        String idStr = req.getParameter("transformer.id");
        if(idStr == null){
            idStr = (String)req.getAttribute("transformer.id");
        }
        if(idStr == null){
            idStr = "-1";
        }
        int id = Integer.parseInt(idStr);

        Map<String,String> transformerValidationReport = new LinkedHashMap<>();


        Transformer transformer = new Transformer();

        if(intValidate(req.getParameter("inputVoltage"))){
            inputVoltage = Integer.parseInt(req.getParameter("inputVoltage"));
        } else {
            transformerValidationReport.put("Input voltage", "This field must be not empty, for example 220");
        }

        if(intValidate(req.getParameter("outputVoltage"))){
            outputVoltage = Integer.parseInt(req.getParameter("outputVoltage"));
        } else {
            transformerValidationReport.put("Output voltage", "This field must be not empty, for example 48");
        }

        if(intValidate(req.getParameter("outputCurrent"))){
            outputCurrent = Integer.parseInt(req.getParameter("outputCurrent"));
        } else {
            transformerValidationReport.put("Output current", "This field must be not empty, for example 15");
        }

        if(intValidate(req.getParameter("mass"))){
            mass = Integer.parseInt(req.getParameter("mass"));
        } else {
            transformerValidationReport.put("Mass", "This field must be not empty, for example 7");
        }

        if(priceValidate(req.getParameter("price"))){
            price = new BigDecimal(req.getParameter("price")).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        } else {
            transformerValidationReport.put("Price", "This field must be not empty, for example 150.35");
        }

//        if(intValidate(req.getParameter("transformer.id"))){
//            id = Integer.parseInt(req.getParameter("transformer.id"));
//        } else {
//            transformerValidationReport.put("Id", "This field incremented automatically");
//        }

        transformer.setInputVoltage(inputVoltage);
        transformer.setOutputVoltage(outputVoltage);
        transformer.setOutputCurrent(outputCurrent);
        transformer.setMass(mass);
        transformer.setPrice(price);
        transformer.setId(id);

        if(transformerValidationReport.size() != 0){
            req.setAttribute("transformerValidationReport",transformerValidationReport);
        }

        req.setAttribute("transformer",transformer);

        return req;
    }


    private static boolean intValidate(String value) {
        if(value == null){
            return false;
        }
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher m = pattern.matcher(value);
        return m.matches();
    }


    private static boolean priceValidate(String value) {
        if(value == null){
            return false;
        }
        Pattern pattern = Pattern.compile("^\\d{1,3}\\.?\\d{0,2}$");
        Matcher m = pattern.matcher(value);
        return m.matches();
    }

    public static boolean update(Transformer transformer) {
        return TransformersDao.update(transformer);
    }

    public static boolean delete(int id) {
        return TransformersDao.delete(id);
    }

    public static List<Transformer> getTransformersList() {
        return TransformersDao.getTransformersList();
    }
}
