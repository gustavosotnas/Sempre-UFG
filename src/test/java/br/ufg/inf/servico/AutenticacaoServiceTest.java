package br.ufg.inf.servico;

import br.ufg.inf.enums.NiveisCurso;
import br.ufg.inf.enums.TiposResolucao;
import br.ufg.inf.enums.Turnos;
import br.ufg.inf.modelo.CursoUFG;
import br.ufg.inf.modelo.Egresso;
import br.ufg.inf.modelo.HistoricoUFG;
import br.ufg.inf.modelo.LocalizacaoGeografica;
import br.ufg.inf.modelo.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cleber
 */
public class AutenticacaoServiceTest {

    private class AutenticacaoServiceStub extends AutenticacaoService {

        private final Egresso usuarioTeste = new Egresso();

        public AutenticacaoServiceStub() {
            usuarioTeste.setCpf("123456789");
            usuarioTeste.setMail("usuarioTeste@teste.com");
            usuarioTeste.setSenha("senhaTeste");

            usuarioTeste.setNome_mae("Mãe do Egresso");

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                usuarioTeste.setData_nascimento(simpleDateFormat.parse("29/10/1990"));
            } catch (ParseException exception) {
            }

            LocalizacaoGeografica naturalidade = new LocalizacaoGeografica();
            naturalidade.setNomeDoPais("Brasil");
            usuarioTeste.setNaturalidade(naturalidade);

            CursoUFG cursoEngenhariaSoftware = new CursoUFG();
            cursoEngenhariaSoftware.setNome_instanciaAdm("Engenharia de Software");
            CursoUFG cursoCienciasComputacao = new CursoUFG();
            cursoCienciasComputacao.setNome_instanciaAdm("Ciencias da Computação");
            ArrayList<CursoUFG> cursos = new ArrayList<>();
            cursos.add(cursoEngenhariaSoftware);
            cursos.add(cursoCienciasComputacao);
            List<HistoricoUFG> historicosUFG = new ArrayList<>();
            historicosUFG.add(new HistoricoUFG(123456, 0, 0, 0, 0, cursoEngenhariaSoftware, ""));
            historicosUFG.add(new HistoricoUFG(147852, 0, 0, 0, 0, cursoCienciasComputacao, ""));
            usuarioTeste.setLista_historicosUFG(historicosUFG);
        }

        @Override
        public boolean login(String login, String senha) {
            if (login == null || senha == null) {
                setErro("Login e senha são obrigatório(s)");
                setUsuarioAutenticado(null);
                setAutenticado(false);
            } else if ((login.equals(usuarioTeste.getCpf()) || login.equals(usuarioTeste.getMail()))
                    && senha.equals(usuarioTeste.getSenha())) {
                setErro("");
                setUsuarioAutenticado(usuarioTeste);
                setAutenticado(true);
            } else {
                setErro("Login e/ou senha inválido(s)");
                setUsuarioAutenticado(null);
                setAutenticado(false);
            }
            return isAutenticado();
        }

        @Override
        public boolean loginPrimeiroAcesso(Egresso egresso) {
            if (verificaInsuficienciaDadosAutenticacao(egresso)) {
                setErro("Dados insuficientes para autenticação");
                setUsuarioAutenticado(null);
                setAutenticado(false);
            } else if (egresso.getNome_mae().equals(usuarioTeste.getNome_mae())
                    && egresso.getData_nascimento() == usuarioTeste.getData_nascimento()
                    && egresso.getNaturalidade().getNomeDoPais().equals(usuarioTeste.getNaturalidade().getNomeDoPais())
                    && verificaCursoMatricula(egresso.getLista_historicosUFG().get(0))) {
                setErro("");
                setUsuarioAutenticado(egresso);
                setAutenticado(true);
            } else {
                setErro("Dados não conferem");
                setUsuarioAutenticado(null);
                setAutenticado(false);
            }
            return isAutenticado();
        }

        private boolean verificaInsuficienciaDadosAutenticacao(Egresso egresso) {
            return (egresso == null
                    || egresso.getNome_mae() == null
                    || egresso.getData_nascimento() == null
                    || egresso.getNaturalidade() == null
                    || egresso.getNaturalidade().getNomeDoPais() == null
                    || egresso.getLista_historicosUFG() == null
                    || egresso.getLista_historicosUFG().isEmpty()
                    || egresso.getLista_historicosUFG().get(0) == null
                    || egresso.getLista_historicosUFG().get(0).getCursoUFG() == null
                    || egresso.getLista_historicosUFG().get(0).getCursoUFG().getNome_instanciaAdm() == null);
        }

        private boolean verificaCursoMatricula(HistoricoUFG historicoUFG) {
            boolean cursoMatriculaConferem = false;
            for (HistoricoUFG historicoUFGSalvo : usuarioTeste.getLista_historicosUFG()) {
                if (historicoUFG.getNum_matricula() == historicoUFGSalvo.getNum_matricula()
                        && historicoUFG.getCursoUFG().getNome_instanciaAdm().equals(
                                historicoUFGSalvo.getCursoUFG().getNome_instanciaAdm())) {
                    cursoMatriculaConferem = true;
                    break;
                }
            }
            return cursoMatriculaConferem;
        }

    }

    private Egresso criarEgressoTestePadrao() {
        Egresso usuarioTeste = new Egresso();
        usuarioTeste.setNome_mae("Mãe do Egresso");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            usuarioTeste.setData_nascimento(simpleDateFormat.parse("29/10/1990"));
        } catch (ParseException exception) {
        }

        LocalizacaoGeografica naturalidade = new LocalizacaoGeografica();
        naturalidade.setNomeDoPais("Brasil");
        usuarioTeste.setNaturalidade(naturalidade);

        CursoUFG cursoEngenhariaSoftware = new CursoUFG();
        cursoEngenhariaSoftware.setNome_instanciaAdm("Engenharia de Software");
        CursoUFG cursoCienciasComputacao = new CursoUFG();
        cursoCienciasComputacao.setNome_instanciaAdm("Ciencias da Computação");
        ArrayList<CursoUFG> cursos = new ArrayList<>();
        cursos.add(cursoEngenhariaSoftware);
        cursos.add(cursoCienciasComputacao);
        List<HistoricoUFG> historicosUFG = new ArrayList<>();
        historicosUFG.add(new HistoricoUFG(123456, 0, 0, 0, 0, cursoEngenhariaSoftware, ""));
        historicosUFG.add(new HistoricoUFG(147852, 0, 0, 0, 0, cursoCienciasComputacao, ""));
        usuarioTeste.setLista_historicosUFG(historicosUFG);
        return usuarioTeste;
    }

    /**
     * Teste do método {@link AutenticacaoService#login(java.lang.String, java.lang.String) quando login e senha são ambos nulos.
     */
    @Test
    public void testLoginLoginSenhaNulos() {
        AutenticacaoService autenticacaoService = new AutenticacaoServiceStub();
        assertEquals(false, autenticacaoService.login(null, null));
    }

    /**
     * Teste do método {@link AutenticacaoService#login(java.lang.String, java.lang.String) quando o login é nulo.
     */
    @Test
    public void testLoginLoginNulo() {
        AutenticacaoService autenticacaoService = new AutenticacaoServiceStub();
        assertEquals(false, autenticacaoService.login(null, "senhaTeste"));
    }

    /**
     * Teste do método {@link AutenticacaoService#login(java.lang.String, java.lang.String) quando a senha é nula.
     */
    @Test
    public void testLoginSenhaNula() {
        AutenticacaoService autenticacaoService = new AutenticacaoServiceStub();
        assertEquals(false, autenticacaoService.login("123456789", null));
    }

    /**
     * Teste do método {@link AutenticacaoService#login(java.lang.String, java.lang.String) quando login e senha são diferentes do esperado.
     */
    @Test
    public void testLoginLoginSenhaDiferentes() {
        AutenticacaoService autenticacaoService = new AutenticacaoServiceStub();
        assertEquals(false, autenticacaoService.login("987654321", "minhaSenha"));
    }

    /**
     * Teste do método {@link AutenticacaoService#login(java.lang.String, java.lang.String) quando o login é diferente do esperado.
     */
    @Test
    public void testLoginLoginDiferente() {
        AutenticacaoService autenticacaoService = new AutenticacaoServiceStub();
        assertEquals(false, autenticacaoService.login("987654321", "senhaTeste"));
    }

    /**
     * Teste do método {@link AutenticacaoService#login(java.lang.String, java.lang.String) quando a senha é diferente do esperado.
     */
    @Test
    public void testLoginSenhaDiferente() {
        AutenticacaoService autenticacaoService = new AutenticacaoServiceStub();
        assertEquals(false, autenticacaoService.login("123456789", "minhaSenha"));
    }

    /**
     * Teste do método {@link AutenticacaoService#login(java.lang.String, java.lang.String) quando o login corresponde ao CPF.
     */
    @Test
    public void testLoginLoginCPF() {
        AutenticacaoService autenticacaoService = new AutenticacaoServiceStub();
        assertEquals(true, autenticacaoService.login("123456789", "senhaTeste"));
    }

    /**
     * Teste do método {@link AutenticacaoService#login(java.lang.String, java.lang.String) quando o login corresponde ao email.
     */
    @Test
    public void testLoginLoginEmail() {
        AutenticacaoService autenticacaoService = new AutenticacaoServiceStub();
        assertEquals(true, autenticacaoService.login("usuarioTeste@teste.com", "senhaTeste"));
    }

    /**
     * Teste do método {@link AutenticacaoService#loginPrimeiroAcesso(br.ufg.inf.modelo.Egresso) quando o egresso é nulo.
     */
    @Test
    public void testLoginPrimeiroAcessoEgressoNulo() {
        Egresso egressoPrimeiroAcesso = null;
        AutenticacaoService instance = new AutenticacaoServiceStub();
        boolean resultado = instance.loginPrimeiroAcesso(egressoPrimeiroAcesso);
        assertEquals(false, resultado);
    }

    //TODO: Inserir demais testes aqui.
    /**
     * Teste do método {@link AutenticacaoService#loginPrimeiroAcesso(br.ufg.inf.modelo.Egresso) quando todas as informações conferem.
     */
    @Test
    public void testLoginPrimeiroAcessoSucesso() {
        Egresso egressoPrimeiroAcesso = criarEgressoTestePadrao();
        AutenticacaoService instance = new AutenticacaoServiceStub();
        boolean resultado = instance.loginPrimeiroAcesso(egressoPrimeiroAcesso);
        assertEquals(false, resultado);
    }

}
