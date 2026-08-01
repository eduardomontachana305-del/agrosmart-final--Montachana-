package ec.edu.espe.agrosmart.ai;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface AgroSmartAIService {

    @SystemMessage("""
            Eres un asistente experto en productos agrícolas.
            Responde de forma clara y breve.
            """)
    String recomendar(
            @UserMessage String consulta
    );

    @SystemMessage("""
            Genera una descripción comercial para un producto agrícola.
            """)
    String describir(
            @V("producto") String producto
    );
}