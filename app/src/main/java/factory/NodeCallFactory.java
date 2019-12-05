package factory;


import service.supportexpressapi.NodeCall;
import service.supportexpressapi.NodeCallImpl;

public final class NodeCallFactory {
    private NodeCallFactory() {
    }
    private enum Singleton {
        INSTANCE;
        private NodeCall nodeCall = new NodeCallImpl();
        public NodeCall get() { return nodeCall;}
    }
    public static NodeCall getNodeCall(){return Singleton.INSTANCE.get();}
}
