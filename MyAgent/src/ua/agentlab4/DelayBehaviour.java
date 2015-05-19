package ua.agentlab4;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;

//��������: ���������� ����������� ����� 300 �� � ������������, �� �� �������� 
//��� ����������� � �������� ���
//�������� WakerBehaviour �� ���� ����� � ������������ ���� �� �������� ������������
// �� ������� ��������� �������� � �� �� ������� ��������� ��
//���� � ���� �������� �������� DelayBehaviour
// DelayBehaviour �������� ��� ����������� � ����� onStart()
//������� ���� ���� �������� ���������� �� ���������� ��� �� ��������� �� �����������
//���� ��� ������ ����������� handleElapsedTimeout, � ������ ������� ��������� �� ��� �� ���������

public class DelayBehaviour extends SimpleBehaviour 
{
   private long    timeout, 
                   wakeupTime;
   private boolean finished = false;
   
   public DelayBehaviour(Agent a, long timeout) {
      super(a);
      this.timeout = timeout;
   }
   
   public void onStart() {
      wakeupTime = System.currentTimeMillis() + timeout;
   }
      
   public void action() 
   {
      long dt = wakeupTime - System.currentTimeMillis();
      if (dt <= 0) {
         finished = true;
         handleElapsedTimeout();
      } else 
         block(dt);
         
   } 
   
   protected void handleElapsedTimeout() 
      { } 
            
   public boolean done() { return finished; }
}