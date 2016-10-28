package br.ufg.inf.stubs;

public class PriorMaintenanceManagerStub {

    private boolean maintenance;

    public void activateMaintenance(){
        this.maintenance = true;
    }

    public void deactivateMaintenance(){
        this.maintenance = false;
    }

    public boolean priorMaintenanceIsActive(){
        return this.maintenance;
    }

}
