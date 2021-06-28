package enade.controller;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.PieChartModel;
import org.primefaces.model.chart.ChartSeries;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import enade.dao.ResultadoDao;
import enade.controller.ResultadoController;
import enade.model.Resultado;

import enade.dao.UsuarioDao;
import enade.model.Usuario;

import enade.dao.TipoUsuarioDao;
import enade.model.TipoUsuario;

@ManagedBean(name="GraficoAlunoNotaMB")
public class AlunoController implements Serializable {

    private BarChartModel barModel;
    private PieChartModel pieModel;

    private ResultadoDao resultadoDao = new ResultadoDao();
    private Resultado resultado = new Resultado();

    private UsuarioDao usuarioDao = new UsuarioDao();
    private Usuario usuario = new Usuario();

    private TipoUsuarioDao tipoUsuarioDao = new TipoUsuarioDao();
    private TipoUsuario tipoUsuario = new TipoUsuario();
    
    @PostConstruct
    public void init() {
        createBarModels();
        createPieModels();
    }

    public BarChartModel getBarModel() {
        return barModel;
    }
 
    public PieChartModel getPieModel() {
        return pieModel;
    }

    public BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries data = new ChartSeries();

        List<Resultado> resultado = resultadoDao.buscarTodas();
        System.out.println(resultado);
        System.out.println("AKI");

        for (Resultado r : resultado)
        {
            data.set(r.getUsuarioidUsuario().getNomeUsuario(), r.getValorObtido());
        };
 
        model.addSeries(data);
 
        return model;
    }

    public PieChartModel initPieModel(){

        PieChartModel model = new PieChartModel();

        //Select * from enade.Usuario a
        //left join enade.Resultado b
        //on a.idUsuario = b.Usuario_idUsuario
        //where a.TipoUsuario_idtipoUsuario = 1

        List<Resultado> resultado = resultadoDao.buscarTodas(); //3
        int totalResultados = resultado.size();

        List<Usuario> alunos = usuarioDao.buscarTodas(); //5
        int totalAlunos = alunos.size();

        model.set("Total alunos que fizeram a prova", totalResultados);//jobs in thousands
        model.set("Total alunos que nao fizeram a prova", (totalAlunos - totalResultados - 1));

        //followings are some optional customizations:
        //set title
        model.setTitle("Provas feitas");
        //set legend position to 'e' (east), other values are 'w', 's' and 'n'
        model.setLegendPosition("e");
        //enable tooltips
        model.setShowDatatip(true);
        //show labels inside pie chart
        model.setShowDataLabels(true);
        //show label text  as 'value' (numeric) , others are 'label', 'percent' (default). Only one can be used.
        model.setDataFormat("percent");
        //format: %d for 'value', %s for 'label', %d%% for 'percent'
        model.setDataLabelFormatString("%dK");
        //pie sector colors
        model.setSeriesColors("aaf,afa");

        return model;
    }
 
    private void createBarModels() {
        createBarModel();
    }

    private void createPieModels() {
        createPieModel();
    }
 
    private void createBarModel() {
        barModel = initBarModel();
 
        barModel.setTitle("Notas");
        barModel.setLegendPosition("ne");
 
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Alunos");
 
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Notas");
        yAxis.setMin(0);
        yAxis.setMax(100);
    }

    private void createPieModel() {
        pieModel = initPieModel();
    }
}