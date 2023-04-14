package Paneles;

public class Principal extends javax.swing.JFrame{
	
    private TablaPrincipal tablaPrincipal;
    public static javax.swing.JTextArea script;
    private javax.swing.JScrollPane scrollPanelScript;
    
    
	public Principal() {    	
		scrollPanelScript = new javax.swing.JScrollPane();
        script = new javax.swing.JTextArea();
        tablaPrincipal = new TablaPrincipal();
        
		initComponents();
	}
	
	private void initComponents() { 
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);	
		
        script.setColumns(20);
        script.setRows(5);
        scrollPanelScript.setViewportView(script);
		
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tablaPrincipal)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPanelScript)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tablaPrincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanelScript, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
	}
}
