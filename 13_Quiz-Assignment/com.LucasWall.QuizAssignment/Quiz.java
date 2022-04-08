//Medium Question 7
				Question7Input = Question7AInput + Question7BInput + Question7CInput + Question7DInput;
				System.out.println(Question7Input);
				if(Question7Submitted == false) {
					if(Question7Input.equals("B")) {
						Score += 1;
						Question7Submitted = true;
						chk_Q7AnswerA.setEnabled(false);
						chk_Q7AnswerB.setEnabled(false);
						chk_Q7AnswerC.setEnabled(false);
						chk_Q7AnswerD.setEnabled(false);
					}
					else if(!Question7Input.equals("")){
						chk_Q7AnswerA.setEnabled(false);
						chk_Q7AnswerB.setEnabled(false);
						chk_Q7AnswerC.setEnabled(false);
						chk_Q7AnswerD.setEnabled(false);
						Question7Submitted = true;
					}
				}
				//Medium Question 8
				Question8Input = Question8AInput + Question8BInput + Question8CInput + Question8DInput;
				System.out.println(Question8Input);
				if(Question8Submitted == false) {
					if(Question8Input.equals("ABD")) {
						Score += 1;
						chk_Q8AnswerA.setEnabled(false);
						chk_Q8AnswerB.setEnabled(false);
						chk_Q8AnswerC.setEnabled(false);
						chk_Q8AnswerD.setEnabled(false);
						Question8Submitted = true;
					}
					else if(!Question8Input.equals("")){
						chk_Q8AnswerA.setEnabled(false);
						chk_Q8AnswerB.setEnabled(false);
						chk_Q8AnswerC.setEnabled(false);
						chk_Q8AnswerD.setEnabled(false);
						Question8Submitted = true;
					}
				}
