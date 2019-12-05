package factory;

import service.NodeService;
import service.NodeServiceImpl;

public final class NodeServiceFactory {
    private NodeServiceFactory(){
    }
    private enum Singleton {
        INSTANCE;
        private NodeService service = new NodeServiceImpl();
        public NodeService get() { return service;}
    }
    public static NodeService getNodeService() {
        return Singleton.INSTANCE.get();
    }
}
