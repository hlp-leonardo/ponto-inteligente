package repositories;

import com.projeto.ponto_inteligente.api.repositories.EmpresaRepository;
import com.projeto.ponto_inteligente.api.repositories.FuncionarioRepository;
import com.projeto.ponto_inteligente.api.repositories.LancamentoRepository;
import entities.Empresa;
import entities.Funcionario;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.event.annotation.AfterTestExecution;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.transaction.BeforeTransaction;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class LancamentoRepositoryTest {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    private Long funcionarioId;

    @BeforeTestExecution
    public void setUp() throws Exception {
        Empresa empresa = this.empresaRepository.save(obterDadosEmpresa());

        Funcionario funcionario = this.funcionarioRepository.save(obterDadosFuncionario(empresa));
        this.funcionarioId = funcionario.getId();

        this.lancamentoRepository.save(obterDadosLancamentos(funcionario));
        this.lancamentoRepository.save(obterDadosLancamentos(funcionario));
    }

    @AfterTestExecution
    public void tearDown() throws Exception {
        this.empresaRepository.deleteAll();
    }

    @Test
    public void testBuscarLancamentosPorFuncionarioId() {

    }

}
